package com.zhongkexinli.micro.serv.common.config.swagger;
 
import java.util.HashSet;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.classmate.ResolvedType;
import com.google.common.base.Optional;

import io.swagger.annotations.ApiModel;
import io.swagger.models.ModelImpl;
import io.swagger.models.properties.DateProperty;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.StringProperty;
import io.swagger.models.properties.UUIDProperty;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
 
/**
 * 注册一个OperationBuilderPlugin
 * @author lsp
 */
@Component
public class ApiResponseBodyReader implements OperationBuilderPlugin {
 
    /**
     * 是否支持此类DocumentationType
     * @param delimiter 当前文档类型
     * @return 如果支持当前类型，则返回true
     */
    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }
 
    /**
     * 如果有需要，可对operationContext执行操作
     * @param operationContext 方法上下文
     */
    @Override
    public void apply(OperationContext operationContext) {
        //此方法上有没有ApiResponseObject注解
        boolean apiResponseObjectHandle = false;
 
        apiResponseObjectHandle = apiResponseObjectHandle(operationContext);
 
        //若此方法上没有ApiResponseObject注解
        if(!apiResponseObjectHandle){
            apiResponseFields(operationContext);
        }
    }
 
    /**
     * 处理ApiResponseFields注解
     * @param operationContext
     */
    private void apiResponseFields(OperationContext operationContext){
        Optional<ApiResponseFields> optional = operationContext.findAnnotation(ApiResponseFields.class);
 
        if(optional.isPresent() && !isVoid(operationContext)){
 
            ApiResponseFields responseFields = optional.get();
 
            String modelName =responseFields.modelName();
 
            if("".equals(modelName)){
                modelName = getModelName(operationContext);
            }
 
            String uuid = modelName + "-" + uuid();
 
            String[] fields = responseFields.fields();
 
            Value2<String, String[]> value2 = new Value2<>(modelName, fields);
 
            ModelCache.specified_cache.put(uuid,value2);
 
            addResponseMessage(operationContext,uuid);
 
        }
 
    }
 
    /**
     * 处理ApiResponseObject注解
     * @param operationContext
     * @return 若此方法上有ApiResponseObject注解，则返回true，否则返回false
     */
    private boolean apiResponseObjectHandle(OperationContext operationContext){
        Optional<ApiResponseObject> optional = operationContext.findAnnotation(ApiResponseObject.class);
 
        if(optional.isPresent()){
 
            ApiResponseObject apiResponseObject = optional.get();
 
            ModelImpl model = createModel(apiResponseObject);
 
 
            String modelName = null;
 
            if(isVoid(operationContext)){
                modelName = "Map";
            }else{
                modelName = getModelName(operationContext);
            }
 
            String uuid = modelName + "-" + uuid();
 
            model.setTitle(uuid);
 
            ModelCache.extra_cache.put(uuid,model);
 
            addResponseMessage(operationContext,uuid);
 
            return true;
        }
 
        return false;
    }
 
 
    private boolean isVoid(OperationContext operationContext){
        ResolvedType type = operationContext.getReturnType();
 
        Class<?> aClass = type.getErasedType();
 
        return aClass == void.class;
    }
 
    /**
     * 获取返回值信息的名字
     * @param operationContext
     * @return
     */
    private String getModelName(OperationContext operationContext){
        ResolvedType type = operationContext.getReturnType();
 
        Class<?> aClass = type.getErasedType();
 
        ApiModel apiModel = aClass.getAnnotation(ApiModel.class);
 
        String modelName = null;
        if(apiModel != null){
            modelName = apiModel.value();
        }
 
        if(modelName==null || "".equals(modelName)){
            modelName = aClass.getSimpleName();
        }
        return modelName;
    }
 
    /**
     * 为operationContext添加状态为200的返ResponseMessage
     * @param operationContext
     * @param typeName
     */
    private void addResponseMessage(OperationContext operationContext,String typeName){
        ResponseMessage responseMessage = new ResponseMessageBuilder()
                .code(200).responseModel(new ModelRef(typeName))
                .build();
 
        HashSet<ResponseMessage> responseMessages = new HashSet<>();
        responseMessages.add(responseMessage);
 
 
        operationContext.operationBuilder().responseMessages(responseMessages);
    }
 
    /**
     * 生成UUID
     * @return
     */
    private String uuid(){
        return UUID.randomUUID().toString();
    }
 
    /**
     * 根据apiResponseObject注解生成一个ModelImpl
     * @param apiResponseObject
     * @return
     */
    private ModelImpl createModel(ApiResponseObject apiResponseObject){
 
        ModelImpl result = new ModelImpl();
 
        //apiResponseObject的类型指定是object
        result.setType("object");
 
        ApiResponseProperty[] properties = apiResponseObject.properties();
 
        for(ApiResponseProperty apiResponseProperty : properties){
 
            String name = apiResponseProperty.name();
            String description = apiResponseProperty.description();
            String type = apiResponseProperty.type();
 
            Property property = null;
 
            if("string".equalsIgnoreCase(type)){
                property = new StringProperty();
            }else if("int".equalsIgnoreCase(type)){
                property = new IntegerProperty();
            }else if("date".equalsIgnoreCase(type)){
                property = new DateProperty();
            }else if("uuid".equalsIgnoreCase(type)){
                property = new UUIDProperty();
            }else{
                throw new RuntimeException("未支持的类型");
            }
 
            property.setDescription(description);
 
            result.property(name,property);
 
        }
 
        return result;
    }
 
}
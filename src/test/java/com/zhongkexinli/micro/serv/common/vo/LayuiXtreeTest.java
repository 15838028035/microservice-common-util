package com.zhongkexinli.micro.serv.common.vo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * layuiX树
 *
 */
public class LayuiXtreeTest {

    private LayuiXtree layuiXtree = new LayuiXtree();

    @Test
    public void setTitleTest() {
        layuiXtree.setTitle("title");
        assertEquals("title", layuiXtree.getTitle());
    }

    @Test
    public void setValueTest() {
        layuiXtree.setValue("value");
        assertEquals("value", layuiXtree.getValue());
    }

    @Test
    public void setDataTest() {
        List<LayuiXtree> data = new ArrayList<>();
        LayuiXtree layuiXtree1 = new LayuiXtree();
        layuiXtree1.setTitle("title1");

        LayuiXtree layuiXtree2 = new LayuiXtree();
        layuiXtree2.setTitle("title2");

        data.add(layuiXtree1);
        data.add(layuiXtree2);

        layuiXtree.setData(data);
        assertEquals(2,layuiXtree.getData().size());
    }

    @Test
    public void testAdd() {
        List<LayuiXtree> data = new ArrayList<>();
        LayuiXtree layuiXtree1 = new LayuiXtree();
        layuiXtree1.setTitle("title1");

        LayuiXtree layuiXtree2 = new LayuiXtree();
        layuiXtree2.setTitle("title2");

        data.add(layuiXtree1);
        data.add(layuiXtree2);

        layuiXtree.add(layuiXtree1);
        layuiXtree.add(layuiXtree2);
        assertEquals(2,layuiXtree.getData().size());
    }

}

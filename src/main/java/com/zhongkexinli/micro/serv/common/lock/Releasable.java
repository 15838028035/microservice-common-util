
package com.zhongkexinli.micro.serv.common.lock;

import java.io.Closeable;


public interface Releasable extends Closeable {

    @Override
    void close();

}

package com.flinkinfo.eplus.api;

/**
 * 服务处理器
 *
 * @author kutzhang@gmail.com
 */
public interface ServiceHandler
{
    String supportServiceName();

    Response handle(Request request) throws Exception;
}

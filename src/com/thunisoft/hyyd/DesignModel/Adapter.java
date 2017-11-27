package com.thunisoft.hyyd.DesignModel;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Adapter {
    
    /**
     * 通过springmvc 学习适配器模式
     */
// 适配器模式的目的是为了不违反开闭原则
//    DispatcherServlet    相当于client
// Controller   相当于不同的Adaptee   
// HttpRequestHandler  相当于不同的Adaptee   
// HandlerAdapter   适配器接口
//    AdvisorAdapter
    
}



/**
 * 下面模拟一个springmvc的实现
 */

class DispacherServlet{
    List <HandlerAdapter> handlerAdapter;
    List <HandlerMapping> handlerMappings;
    static class Init {
        private final static List <HandlerAdapter> handlerAdapter = new ArrayList<HandlerAdapter>();
    }
    public DispacherServlet() {
        handlerAdapter  = Init.handlerAdapter;
        handlerAdapter.add(new AnnotationHandlerAdapter());
    }
    public void doDispacher(HttpServletRequest request,HttpServletResponse response){
        for (HandlerAdapter adpterMapping:handlerAdapter) {
            if(adpterMapping.support(request)){
                adpterMapping.handler(request);
            }
        }
    }
    
}
interface HandlerMapping{
    void handler();
}

class AnnotationController implements HandlerMapping{

    public void handler() {
        
    }
    
}

interface HandlerAdapter {
    boolean support(HttpServletRequest request);
    void handler(HttpServletRequest request);
}


class AnnotationHandlerAdapter implements HandlerAdapter{
    AnnotationController annotationController;
    public boolean support(HttpServletRequest request) {
        if(request !=null&&request instanceof AnnotationController){
            return true;
        }
        return false;
    }

    public void handler(HttpServletRequest request) {
        annotationController.handler();
    }
    
}




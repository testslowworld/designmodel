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
    
}



/**
 * 下面模拟一个springmvc的实现
 */

class DispacherServlet{
    List <AdapterMapping> adpterMappings;
    static class Init {
        private final static List <AdapterMapping> adpterMappings = new ArrayList<AdapterMapping>();
    }
    public DispacherServlet() {
        adpterMappings  = Init.adpterMappings;
        adpterMappings.add(new AnnotationAdapter());
    }
    public void doDispacher(HttpServletRequest request,HttpServletResponse response){
        for (AdapterMapping adpterMapping:adpterMappings) {
            if(adpterMapping.support(request)){
                adpterMapping.handler(request);
            }
        }
    }
    
}
interface Controller{
    void handler();
}

class AnnotationController implements Controller{

    public void handler() {
        
    }
    
}

interface AdapterMapping {
    boolean support(HttpServletRequest request);
    void handler(HttpServletRequest request);
}


class AnnotationAdapter implements AdapterMapping{
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




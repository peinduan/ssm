package cn.it.utils;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;

public class Href {

    public static ModelAndView go(String attributeName, Object attributeValue,@Nullable String viewName){
        ModelAndView mv = new ModelAndView();
        mv.addObject(attributeName,attributeValue);
        mv.setViewName(viewName);
        return mv;
    }
}

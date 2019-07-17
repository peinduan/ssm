package cn.it.utils;

import com.github.pagehelper.PageInfo;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class Href {

    public static ModelAndView go(String attributeName, Object attributeValue,@Nullable String viewName){
        ModelAndView mv = new ModelAndView();
        mv.addObject(attributeName,attributeValue);
        mv.setViewName(viewName);
        return mv;
    }

    public static<T> ModelAndView go(String attributeName, List<T> attributeValue, @Nullable String viewName){
        ModelAndView mv = new ModelAndView();
        PageInfo<T> tPageInfo = new PageInfo<T>(attributeValue);
        mv.addObject(attributeName,tPageInfo);
        mv.setViewName(viewName);
        return mv;
    }

}

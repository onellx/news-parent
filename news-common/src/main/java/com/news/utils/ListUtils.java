package com.news.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListUtils
 * @Author One_llx
 * @Date 2018/11/29 0029 下午 1:40
 * @Version 1.0
 */
public class ListUtils {

    private final static String param1="retainList";
    private final static String param2="removeList";


    /**
     * 长list中包含短list中哪些元素
     * @param t1
     * @param t2
     * @param <T>
     * @return
     */
    public static <T>List<T> retainList(List<T> t1,List<T> t2){
        return playMethod(t1,t2,param1);
    }

    /**
     * 长list中不包含短list中哪些元素
     * @param t1
     * @param t2
     * @param <T>
     * @return
     */
    public static <T>List<T> removeList(List<T> t1,List<T> t2){
        return playMethod(t1,t2,param2);
    }

    private static <T>List<T> playMethod(List<T> t1,List<T> t2,String param){
        List<T> list1=new ArrayList<T>();
        List<T> list2=new ArrayList<T>();
        list1.addAll(t1);
        list2.addAll(t2);
        if (list1.size()>list2.size()){
            if (param.equals(param1)) {
                list1.retainAll(list2);
            } else {
                list1.removeAll(list2);
            }
            return list1;
        }else{
            if (param.equals(param1)) {
                list1.retainAll(list2);
            } else {
                list1.removeAll(list2);
            }
            return list1;
        }
    }

}

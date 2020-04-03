package com.gc;


import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class GarbageCollectorBeans {
    public static void main(String...args) {
        List<GarbageCollectorMXBean> mxBeanList =
                ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean bean : mxBeanList) {
            System.out.println(bean.getName());
            System.out.println(bean.getCollectionCount());
            System.out.println(bean.getCollectionTime());
        }
    }

}

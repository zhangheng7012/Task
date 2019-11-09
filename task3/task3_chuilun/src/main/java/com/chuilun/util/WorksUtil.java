package com.chuilun.util;

import com.chuilun.pojo.Works;
import com.chuilun.service.WorksService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorksUtil {
    // 根据传入的service、作品集id、上下架状态查询对应的一级、二级作品集
    public static void findWorksByParentId(WorksService worksService, Works works,
                                           List<Works> replies) {
        Map<String,Object> map = new HashMap<>();
        // 父作品集id，非0，二级作品集
        map.put("parentWorksId",works.getId());
        map.put("status",true);
        // 根据父作品集id、上下架状态，查询二级作品集
        List<Works> worksList = worksService.selectWorksByParentId(map);
        // 遍历所有二级作品集
        for (Works secWorks : worksList) {
            // 将二级作品集依次加入一级作品集的集合
            replies.add(secWorks);
        }
    }
}

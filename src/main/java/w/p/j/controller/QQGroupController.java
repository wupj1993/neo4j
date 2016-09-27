package w.p.j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import w.p.j.domain.QQ;
import w.p.j.domain.QQGroup;
import w.p.j.service.QQGroupService;

import java.util.HashSet;
import java.util.Set;

/**
 * Name：QQGroupController
 * Time：2016/9/26 16:23
 * author：WPJ587
 * description：qq群控制器
 **/
@Controller
@RequestMapping("/qqgroup")
public class QQGroupController {
    @Autowired
    private QQGroupService qqGroupService;

    @RequestMapping("/add")
    @ResponseBody
    public Object qqGroup() {
        qqGroupService.deleteAll();
        /**
         * 创建第一个qq群
         */
        QQGroup qqGroup = new QQGroup();
        qqGroup.setNumber("66666666");
        qqGroup.setName("时尚");
        Set<QQ> qqs = new HashSet<>();
        QQ master = new QQ();
        master.setAge(77.4f);
        master.setName("似故人来");
        master.setNumber("757671834");
        for (int i = 0; i < 20; i++) {
            QQ qq = new QQ();
            qq.setAge(2.3f + i);
            qq.setName("超人" + i + "号");
            qq.setNumber((10933032 + i) + "");
            qqs.add(qq);

        }
        qqGroup.setMaster(master);
        qqGroup.setMember(qqs);
        qqGroup = qqGroupService.createOrUpdate(qqGroup);
        /**
         * 创建第二个qq群
         */
        QQGroup qqGroupTwo = new QQGroup();
        qqGroupTwo.setName("IT交流群");
        Set<QQ> qqss = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            QQ qq = new QQ();
            qq.setAge(2.3f + i);
            qq.setName("菜鸟" + i + "号");
            qq.setNumber((32311212 + i) + "");
            qqss.add(qq);
        }
        qqss.add(master);
        qqGroupTwo.setNumber("88888888");
        qqGroupTwo.setMember(qqss);
        QQ master1 = new QQ();
        master1.setAge(3.4f);
        master1.setName("小吴");
        master1.setNumber("10933035");
        qqGroupTwo.setMaster(master1);
        qqGroupService.createOrUpdate(qqGroupTwo);
        return qqGroup;
    }
}

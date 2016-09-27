package w.p.j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import w.p.j.domain.QQ;
import w.p.j.service.QQService;

/**
 * Name：IndexController
 * Time：2016/9/26 16:06
 * author：WPJ587
 * description：控制器
 **/
@Controller
@RequestMapping("/qq")
public class IndexController {
    @Autowired
    private QQService qqService;

    @RequestMapping("/add")
    @ResponseBody
    public Object add() {
        QQ qq = new QQ();
        qq.setAge(2.3f);
        qq.setName("似故人来");
        qq.setNumber("757671834");
        QQ qqres = qqService.createOrUpdate(qq);
        return qqres;
    }
}

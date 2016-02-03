package org.springframework.neo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.neo.domain.QQ;
import org.springframework.neo.domain.World;
import org.springframework.neo.repo.QQRepository;
import org.springframework.neo.repo.WorldRepository;
import org.springframework.neo.service.GalaxyService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableNeo4jRepositories("org.springframework.neo.repo")
public class App implements CommandLineRunner {
    @Autowired
    GalaxyService galaxyService;
    @Autowired
    WorldRepository worldRepository;
    @Autowired
    QQRepository qqRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public static Collection<QQ> makeAllQQWorldsAtonce() {
        Collection<QQ> friendship = new ArrayList<>();// 代表交际圈
        // 制造陌生人
        List<QQ> stranger = new ArrayList<>();
        stranger.add(new QQ("谢耳朵", "2478833"));
        stranger.add(new QQ("夫复何求", "8304432"));
        stranger.add(new QQ("[山东]尛⑦", "46730634"));
        stranger.add(new QQ("[澳门]雪狼", "47495847"));
        stranger.add(new QQ("是我", "47732636"));
        stranger.add(new QQ("[辽宁]OWEN", "48211210"));
        stranger.add(new QQ("浙江阿褚", "51712181"));
        stranger.add(new QQ("[广州]Benjamin", "54516995"));
        stranger.add(new QQ("北京安卓新手", "56040929"));
        // 把小号当作生死之交
        QQ wpj = new QQ("伤心时请想起我", "541048758");
        for (int i = 0; i < stranger.size(); i++) {
            wpj.addQQToStranger(stranger.get(i));
            stranger.get(i).addQQToStranger(wpj);
        }

        friendship.addAll(stranger);
        friendship.add(wpj);

        QQ xiaohao = new QQ("难过时请想起我", "291745569");
        wpj.addQQToLiveDie(xiaohao);
        xiaohao.addQQToLiveDie(wpj);

        friendship.add(xiaohao);

        // 制造普通朋友
        List<QQ> common = new ArrayList<>();
        common.add(new QQ("猫看着戏！", "5448710"));
        common.add(new QQ("暗影刺客", "6637152"));
        common.add(new QQ("qwe", "11573395"));
        common.add(new QQ("望星空", "47495847"));
        common.add(new QQ("寒梅笑雪", "12327649"));
        common.add(new QQ("大鹏", "18771478"));
        common.add(new QQ("会说话的哑巴", "24355591"));
        common.add(new QQ("一面湖水", "25617696"));
        common.add(new QQ("饮水思源", "28119800"));
        for (int i = 0; i <common.size() ; i++) {
            common.get(i).addQQToCommon(stranger.get(i));
            stranger.get(i).addQQToCommon(common.get(i));
            wpj.addQQToStranger(common.get(i));
            common.get(i).addQQToStranger(wpj);
        }
        friendship.addAll(common);
        return friendship;

    }

    public static Collection<World> makeAllWorldsAtOnce() {

        Collection<World> worlds = new ArrayList<World>();

        // Solar worlds

        worlds.add(new World("水星", 0));
        worlds.add(new World("金星", 0));

        World earth = new World("地球", 1);
        World mars = new World("火星", 2);

        mars.addRocketRouteTo(earth);
        earth.addRocketRouteTo(mars);

        worlds.add(earth);
        worlds.add(mars);

        worlds.add(new World("木星", 63));
        worlds.add(new World("土星", 62));
        worlds.add(new World("天王星", 27));
        worlds.add(new World("海王星", 13));

        // Norse worlds
        worlds.add(new World("Alfheimr", 0));
        worlds.add(new World("尘世", 1));
        worlds.add(new World("斯帕尔海姆", 2));
        worlds.add(new World("仙宫", 63));
        worlds.add(new World("帮助", 62));


        return worlds;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("------start-------------");
        qqRepository.deleteAll();
        qqRepository.save(makeAllQQWorldsAtonce());
        System.out.println("-------over------------");
    }
}
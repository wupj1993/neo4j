package org.springframework.neo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.neo.domain.World;
import org.springframework.neo.repo.WorldRepository;
import org.springframework.neo.service.GalaxyService;

import java.util.ArrayList;
import java.util.Collection;

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

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Iterable iterable = worldRepository.findAll();
        World myWorld = galaxyService.createWorld("mine", 0);
        Collection<World> foundWorlds = (Collection<World>) galaxyService.getAllWorlds();
        worldRepository.save(makeAllWorldsAtOnce());
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
}
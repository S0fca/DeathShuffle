package me.ash.deathshuffle;

import java.util.Random;

public class Deaths {

    public String death(String player) {
        Random r = new Random();
        int random = r.nextInt(31);
        switch (random) {
            case 0:
                return "was pricked to death";//cactus
            case 1:
                return "drowned";
            case 2:
                return "blew up";
            case 3:
                return "hit the ground too hard";
            case 4:
                return "fell from a high place";
            case 5:
                return "fell off a ladder";
            case 6:
                return "was blown up by";
            case 7:
                return "was killed by [Intentional Game Design]";//bed in nether
            case 8:
                return "tried to swim in lava to escape";
            case 9:
                return "was poked to death by a sweet berry bush";
            case 10:
                return "was squashed by a falling anvil";
            case 11:
                return "was squished too much";
            case 12:
                return "was blown up by " + player;
            case 13:
                return "went up in flames";
            case 14:
                return "burned to death";
            case 15:
                return "tried to swim in lava";
            case 16:
                return "discovered the floor was lava";
            case 17:
                return "froze to death";
            case 18:
                return "was slain by Zombie";
            case 19:
                return "was shot by Skeleton";
            case 20:
                return "was slain by Spider";
            case 21:
                return "was blown up by Creeper";
            case 22:
                return "was slain by Iron Golem";
            case 24:
                return "was slain by Enderman";
            case 25:
                return "was slain by Wolf";
            case 26:
                return "was stung to death";
            case 27:
                return "suffocated in a wall";
            case 28:
                return "was shot by Arrow";
            case 29:
                return "was shot by " + player;
            case 30:
                return "whilst trying to escape";
            default:
                return "Idk";
        }
    }
}
/*
"was slain by Zombified Piglin"
"was slain by Hoglin"
"was slain by Piglin"
"was slain by Pufferfish"
"was impaled on a stalagmite"
"was skewered by a falling stalactite"
"fell out of the world"
"fell off some vines"
 */

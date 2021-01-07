package com.oliver.adv.Game.Items;

import com.oliver.adv.Game.AttackEntities.AttackEntity;

public class Treasure extends Item {
    public Treasure(String name, String description) {
        super(name, description);
    }

    @Override
    public void Pickup(AttackEntity entity) {
        System.out.println("                  _.--.\n"
                           + "              _.-'_:-'||\n"
                           + "          _.-'_.-::::'||\n"
                           + "     _.-:'_.-::::::'  ||\n"
                           + "   .'`-.-:::::::'     ||\n"
                           + "  /.'`;|:::::::'      ||_\n"
                           + " ||   ||::::::'      _.;._'-._\n"
                           + " ||   ||:::::'   _.-!oo @.!-._'-.\n"
                           + " '.  ||:::::.-!() oo @!()@.-'_.||\n"
                           + "   '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n"
                           + "     `>'-.!@%()@'@_%-'_.-o _.|'||\n"
                           + "      ||-._'-.@.-'_.-' _.-o  |'||\n"
                           + "      ||=[ '-._.-\\U/.-'    o |'||\n"
                           + "      || '-.]=|| |'|      o  |'||\n"
                           + "      ||      || |'|        _| ';\n"
                           + "      ||      || |'|    _.-'_.-'\n"
                           + "      |'-._   || |'|_.-'_.-'\n"
                           + "      '-._'-.|| |' `_.-'\n"
                           + "           '-.||_/.-'\n");
    }

}

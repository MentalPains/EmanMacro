/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.djtheredstoner.devauth.common.DevAuth
 *  net.minecraft.launchwrapper.Launch
 */
package baritone.launch;

import me.djtheredstoner.devauth.common.DevAuth;
import net.minecraft.launchwrapper.Launch;

public class Login {
    public static void main(String[] stringArray) {
        Launch.main((String[])new DevAuth().processArguments(stringArray));
    }
}

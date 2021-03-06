package net.unit8.job_streamer.agent.util;

import clojure.lang.*;

/**
 * @author Yuki Seki
 */
public class SystemUtil {
    public static Object getSystem() {
        Var varSystem = RT.var("job-streamer.agent.main", "system");
        if (varSystem.isBound()) {
            Atom mainSystemAtom = (Atom) varSystem.get();
            Object system = mainSystemAtom.deref();
            if (system != null) {
                return system;
            }
        }

        // Fallback... System must be started in REPL.
        return RT.var("reloaded.repl", "system").get();
    }
}


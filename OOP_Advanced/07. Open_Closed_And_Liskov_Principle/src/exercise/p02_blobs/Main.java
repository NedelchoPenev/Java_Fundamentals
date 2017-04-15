package exercise.p02_blobs;

import exercise.p02_blobs.core.BlobsDatabase;
import exercise.p02_blobs.core.Engine;
import exercise.p02_blobs.core.factories.AttackFactory;
import exercise.p02_blobs.core.factories.BehaviorFactory;
import exercise.p02_blobs.core.factories.BlobFactory;
import exercise.p02_blobs.interfaces.Runnable;
import exercise.p02_blobs.io.ConsoleWrite;
import exercise.p02_blobs.io.InputReader;
import exercise.p02_blobs.models.CombatLog;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ReflectiveOperationException {
        Runnable engine = new Engine(
                new InputReader(),
                new ConsoleWrite(),
                new BlobFactory(),
                new AttackFactory(),
                new BehaviorFactory(),
                new CombatLog(new ConsoleWrite()),
                new BlobsDatabase(new ArrayList<>()));

        engine.run();
    }
}

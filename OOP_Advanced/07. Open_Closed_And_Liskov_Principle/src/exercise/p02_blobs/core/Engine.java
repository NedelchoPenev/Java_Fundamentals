package exercise.p02_blobs.core;

import exercise.p01_Logger.contracts.Writable;
import exercise.p02_blobs.interfaces.*;
import exercise.p02_blobs.interfaces.Readable;
import exercise.p02_blobs.interfaces.Runnable;

import java.io.IOException;

public class Engine implements Runnable {

    private boolean isRunning;

    private Readable reader;
    private Writable writer;
    private BlobCreator blobCreator;
    private AttackCreator attackCreator;
    private BehaviorCreator behaviorCreator;
    private Log log;
    private Data data;

    private boolean isEventToggled;

    public Engine(Readable reader, Writable writer, BlobCreator blobCreator, AttackCreator attackCreator,
                  BehaviorCreator behaviorCreator, Log log, Data data) {
        this.reader = reader;
        this.writer = writer;
        this.blobCreator = blobCreator;
        this.attackCreator = attackCreator;
        this.behaviorCreator = behaviorCreator;
        this.log = log;
        this.data = data;
    }

    @Override
    public void run() throws IOException, ReflectiveOperationException {
        this.isRunning = true;

        while (this.isRunning){
            String input = reader.readLine();

            this.executeInput(input.split("\\s+"));
            this.updateBlobs();
        }
    }

    private void executeInput(String[] args) throws ReflectiveOperationException {
        String command = args[0];

        switch (command) {
            case "create":
                this.executeCreate(args);
                break;
            case "attack":
                this.executeAttack(args);
                break;
            case "pass":
                break;
            case "status":
                this.executeStatus();
                break;
            case "report-events":
                this.isEventToggled = true;
                break;
            case "drop":
                this.isRunning = false;
                break;
        }
    }

    private void updateBlobs() {
        for (Creature creature : this.data.getBlobs()) {
            creature.update();
        }
    }

    private void executeStatus() {
        for (Creature blob : this.data.getBlobs()) {
            this.writer.writeLine(blob.toString());
        }
    }

    private void executeAttack(String[] inputTokens) {
        Creature attacker = this.data.getBlob(inputTokens[1]);
        Creature target = this.data.getBlob(inputTokens[2]);
        attacker.attack(target);
    }

    private void executeCreate(String[] createTokens) throws ReflectiveOperationException {
        String name = createTokens[1];
        int health = Integer.valueOf(createTokens[2]);
        int damage = Integer.valueOf(createTokens[3]);

        String behaviorType = createTokens[4];
        Behavior behavior = this.behaviorCreator.getBehavior(behaviorType);

        String attackType = createTokens[5];
        Attack attack = this.attackCreator.getAttack(attackType);

        Creature blob = blobCreator.create(name, health, damage, behavior, attack);
        this.data.addBlob(blob);

        if (isEventToggled) {
            blob.getListeners().add(this.log);
        }
    }
}

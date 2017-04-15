package exercise.p02_blobs.models;

import exercise.p02_blobs.interfaces.*;

import java.util.ArrayList;
import java.util.Collection;

public class Blob implements Creature{

    private String name;
    private int currentHealth;
    private int damage;
    private Behavior behavior;
    private Attack attack;
    private int triggerCount;
    private Collection<Listener> listeners;

    private int initialHealth;

    public Blob(String name, int health, int damage, Behavior behavior, Attack attack) {
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;
        this.listeners = new ArrayList<>();

        this.initialHealth = health;
    }

    @Override
    public int getHealth() {
        return this.currentHealth;
    }

    @Override
    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < 0) {
            this.currentHealth = 0;

            if (this.behavior.isTriggered()) {
                String message = String.format("Blob %s was killed", this.getName());
                Event event = new BlobEvent(this, message);
                this.fireEvent(event);
            }
        }

        if (this.currentHealth <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
            this.triggerBehavior();
        }
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    @Override
    public void attack(Creature target) {
        this.attack.execute(this, target);
    }

    @Override
    public void respond(int damage) {
        int currentHealth = this.getHealth();
        currentHealth -= damage;
        this.setHealth(currentHealth);
    }

    @Override
    public void triggerBehavior() {
        String message = String.format("Blob %s toggled %sBehavior", this.getName(), this.behavior.getClass().getSimpleName());
        Event event = new BlobEvent(this, message);
        this.fireEvent(event);
        this.behavior.trigger(this);
    }

    @Override
    public Behavior getBehavior() {
        return this.behavior;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void update() {
        if (this.behavior.isTriggered()) {
            this.triggerCount++;
            if (this.triggerCount > 1) {
                this.behavior.applyRecurrentEffect(this);
            }
        }
    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED", this.getName());
        }

        return String.format("Blob %s: %s HP, %s Damage", this.getName(), this.getHealth(), this.getDamage());
    }

    @Override
    public Collection<Listener> getListeners() {
        return this.listeners;
    }

    @Override
    public void fireEvent(Event event) {
        for (Listener listener : this.getListeners()) {
            if (listener != null) {
                listener.update(this, event);
            }
        }
    }
}

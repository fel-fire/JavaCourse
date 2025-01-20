package oop;

abstract class Weapon {
    private int ammo;

    public Weapon(int ammo) {
        if (ammo<0) throw new IllegalArgumentException("Ammo must be more than 0");
        this.ammo = ammo;
    }
    abstract void shoot();

    public int ammo() {
        return ammo;
    }
    public boolean getAmmo() {
        if (ammo == 0) return false;
        ammo--;
        return true; // Заменил на true строку из задачника (было - return false). Нормально не работало
    }
    public int load(int ammo) {
        if (ammo < 0) throw new IllegalArgumentException("Ammo must be more than 0");
        int tmp = this.ammo; // Заменил на это строку из задачника (было - int tmp = ammo). Нормально не работало
        this.ammo = ammo;
        return tmp;
    }
}

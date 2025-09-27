class TypeCtoLightningAdapter {
    constructor(lightningPhone) {
        this.lightningPhone = lightningPhone;
    }

    charge() {
        console.log("Using adapter to connect Type-C to Lightning... (JavaScript)");
        this.lightningPhone.chargeWithLightning();
    }
}

const lightningPhone = {
    chargeWithLightning() {
        console.log("Charging iPhone via Lightning... (object imitation)");
    }
};

const adapter = new TypeCtoLightningAdapter(lightningPhone);
adapter.charge();

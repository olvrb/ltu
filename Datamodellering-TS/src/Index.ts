import { ConnectDatabase } from "./Database/Index";
import "reflect-metadata";
import { Tenant } from "./Database/Entities/Tenant";
import { Contract } from "./Database/Entities/Contract";
import { RentedProperty } from "./Database/Entities/RentedProperty";

ConnectDatabase().then(async (test) => {
    console.log(test.entityMetadatas[0].oneToOneRelations);

    const tenant: Tenant = new Tenant();
    tenant.Name = "Oliver";
    tenant.Contract = new Contract();
    const rentedProperty = new RentedProperty();
    tenant.Contract.RentedProperty = rentedProperty;
    rentedProperty.Tenant = tenant;
    rentedProperty.Contract = tenant.Contract;
    tenant.PersonNummer = "0204150072";
    tenant.RentedProperty = rentedProperty;
    tenant.save();

    const t = await Tenant.find({ where: { PersonNummer: "0204150072" } });
    console.log(t);
});

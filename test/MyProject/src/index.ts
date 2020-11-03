import "reflect-metadata";
import { createConnection } from "typeorm";
import { Tenant } from "./entity/Tenant";
import { Contract } from "./entity/Contract";
import { RentedProperty } from "./entity/RentedProperty";

createConnection()
  .then(async (connection) => {
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
  })
  .catch((error) => console.log(error));

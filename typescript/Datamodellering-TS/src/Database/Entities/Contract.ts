import {
    Entity,
    PrimaryColumn,
    PrimaryGeneratedColumn,
    OneToOne,
    Generated,
    BaseEntity,
} from "typeorm";
import { Tenant } from "./Tenant";
import { RentedProperty } from "./RentedProperty";

@Entity()
export class Contract extends BaseEntity {
    @PrimaryColumn()
    @Generated("uuid")
    public Id?: string;

    @OneToOne((type) => Tenant, (tenant) => tenant.Contract)
    public Tenant: Tenant;

    @OneToOne(
        (type) => RentedProperty,
        (rentedProperty) => rentedProperty.Contract
    )
    public RentedProperty: RentedProperty;
}

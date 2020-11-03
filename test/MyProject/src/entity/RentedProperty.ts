import {
    Entity,
    PrimaryGeneratedColumn,
    Column,
    OneToOne,
    Generated,
    PrimaryColumn,
    BaseEntity,
} from "typeorm";
import { Tenant } from "./Tenant";
import { Contract } from "./Contract";

@Entity()
export class RentedProperty extends BaseEntity {
    @PrimaryColumn()
    @Generated("uuid")
    public Id: string;

    @Column()
    public ApartmentNumber: string;

    @OneToOne((type) => Tenant, (tenant) => tenant.RentedProperty)
    public Tenant: Tenant;

    @OneToOne((type) => Contract, (contract) => contract.RentedProperty)
    public Contract: Contract;
}

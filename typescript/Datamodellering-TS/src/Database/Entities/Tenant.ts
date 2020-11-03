import { Entity, PrimaryColumn, Column, OneToOne, BaseEntity } from "typeorm";
import { Contract } from "./Contract";
import { RentedProperty } from "./RentedProperty";

@Entity()
export class Tenant extends BaseEntity {
    @PrimaryColumn()
    public PersonNummer: string;

    @Column()
    public Name: string;

    @OneToOne((type) => Contract, (contract) => contract.Tenant, {
        eager: true,
    })
    public Contract: Contract;

    @OneToOne(
        (type) => RentedProperty,
        (rentedProperty) => rentedProperty.Tenant
    )
    public RentedProperty: RentedProperty;
}

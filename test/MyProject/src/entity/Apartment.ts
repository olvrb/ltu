import { Entity, Column } from "typeorm";
import { RentedProperty } from "./RentedProperty";

@Entity()
export class Apartment extends RentedProperty {}

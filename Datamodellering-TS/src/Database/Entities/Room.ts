import { Entity, Column } from "typeorm";
import { RentedProperty } from "./RentedProperty";

@Entity()
export class Room extends RentedProperty {
    @Column()
    public RoomNumber: string;
}

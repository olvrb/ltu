import { ConnectionOptions } from "typeorm";

export class Configuration {
    public static Database: ConnectionOptions = {
        type: "sqlite",

        database: "datamodellering.sqlite",
        synchronize: true,
    };
}

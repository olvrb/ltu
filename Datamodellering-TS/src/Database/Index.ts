import { createConnection } from "typeorm";
import { Configuration } from "../Config";
import { join } from "path";

export function ConnectDatabase() {
    console.log(join(__dirname, "/Entities/*.js"));

    return createConnection({
        entities: [join(__dirname, "/Entities/*.js")],
        ...Configuration.Database,
    });
}

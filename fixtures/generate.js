import { randomBytes } from 'crypto'
import { createWriteStream } from 'fs'
import { resolve } from 'path'
import { v4 as uuid } from 'uuid'


// clear text: password
const DEFAULT_PASSWORD = '$2y$10$aCf7tv9jG124O5yzRWZ1geWdFACWbBYbDjGxsvwTNfUtpKIRQflou'

const generateUser = (usernamePrefix = '') => ({
    id: uuid(),
    username: usernamePrefix + '-' + randomBytes(12).toString('hex'),
    password: DEFAULT_PASSWORD,
})

const admins = [...Array(10).keys()]
    .map(() => ({
        ...generateUser('admin'),
        role: 'ADMIN'
    }))

const deliveryPersons = [...Array(100).keys()]
    .map(() => ({
        ...generateUser('delivery-person'),
        role: 'DELIVERY_PERSON'
    }))

const colis = [...Array(1000).keys()]
    .map(() => ({
       id: uuid(),
       address: 'some address',
       email: randomBytes(12).toString('hex') + '@somewhere.com',
       deliveryPersonId: Math.random() > 0.5 ? null : deliveryPersons[Math.floor(Math.random() * deliveryPersons.length)].id
    }))

const colisSql = createWriteStream(resolve('./src/test/resources/colis.sql'))

colisSql.once('error', err => console.error(err))

colisSql.write('BEGIN TRANSACTION;\n')

for (const c of colis){
    // évidement ce code n'est pas prévu pour s'exécuter en production et est vulnérable aux injections.
    colisSql.write(`INSERT INTO colis ("id", "address", "email", "delivery_person_id") VALUES ('${c.id}', '${c.address}', '${c.email}', ${c.deliveryPersonId ? '\'' + c.deliveryPersonId + '\'' : 'NULL'});\n`)
}

colisSql.write('COMMIT;\n')

colisSql.close()

const usersYml = createWriteStream(resolve('./src/test/resources/users.yml'))

usersYml.once('error', err => console.error(err))

usersYml.write(`colibri:\n  users:\n`)
for (const user of [...admins, ...deliveryPersons]){
    usersYml.write(`    - id: ${user.id}\n      username: ${user.username}\n      password: ${user.password}\n      role: ${user.role}\n`)
}
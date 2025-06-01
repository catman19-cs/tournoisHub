import mysql from 'mysql2/promise'

export default defineEventHandler(async (event) => {
    const body = await readBody(event)
    const {email,mdp}=body
    const resultat=false
  const connection = await mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'tournoishub'
  })

  const [rows] = await connection.execute(`SELECT email,mdp FROM joueur where email=${email}`)
  await connection.end()
if(rows.mdp ==mdp){
    resultat ==true
}
  return rows
})
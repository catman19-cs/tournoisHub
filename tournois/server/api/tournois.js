import mysql from 'mysql2/promise'

export default defineEventHandler(async (event) => {
  const connection = await mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'tournoishub'
  })

  const [rows] = await connection.execute('SELECT nom ,periode,date_debut,regle,prix,privée,lieu,nb_par_equipe,libelle,libelle_categorie FROM tournois t,type ty,categorie c where t.id_type=ty.id_type and ty.id_categorie=c.id_categorie')
  await connection.end()

  return rows
})
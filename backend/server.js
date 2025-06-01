const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const mysql = require('mysql2');

const app = express();
const port = 6000;

// Middleware
app.use(cors());  // Permet les requêtes CORS depuis le frontend
app.use(bodyParser.json());  // Pour analyser les données JSON envoyées dans les requêtes POST

// Connexion à la base de données MySQL
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',  // Remplacez par votre utilisateur MySQL
  password: '',  // Remplacez par votre mot de passe MySQL
  database: 'tournoishub'  // Le nom de la base de données que nous avons créée
});

// Vérifier la connexion
db.connect((err) => {
  if (err) {
    console.error('Erreur de connexion à MySQL :', err);
    return;
  }
  console.log('Connexion à MySQL réussie');
});

// Route GET pour récupérer les messages depuis MySQL
app.get('/api/messages', (req, res) => {
  db.query('SELECT * FROM inscription', (err, results) => {
    if (err) {
      console.error('Erreur lors de la récupération des messages :', err);
      res.status(500).send('Erreur du serveur');
      return;
    }
    res.json(results);  // Envoie les résultats de la requête SQL sous forme de JSON
  });
});

// Démarrer le serveur
app.listen(port, () => {
  console.log(`API en cours d'exécution sur http://localhost:${port}`);
});

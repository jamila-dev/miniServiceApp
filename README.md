# miniServiceApp
Service de Gestion de Campagnes de Dons

Ceci est une application Spring Boot pour gérer des campagnes de dons, permettant aux utilisateurs de créer et gérer des campagnes et des dons.

Fonctionnalités





Récupérer les campagnes actives (GET /api/campagnes/actives).



Récupérer toutes les campagnes (GET /api/campagnes).



Créer un don pour une campagne (POST /api/campagnes/{id}/dons).



Récupérer les dons d'une campagne (GET /api/campagnes/{id}/dons).



Documentation API via Swagger (http://localhost:8080/swagger-ui.html).



Base de données en mémoire H2 pour la persistance (http://localhost:8080/h2-console).

Prérequis





Java 17+



Maven 3.6+



Postman (pour les tests)



Git (pour le contrôle de version)

Installation





Cloner le dépôt :

git clone <url-du-dépôt>
cd donation-service



Construire le projet :

mvn clean install



Lancer l'application :

mvn spring-boot:run





Alternativement, construire et exécuter le JAR :

mvn clean package
java -jar target/donation-service-1.0-SNAPSHOT.jar

Utilisation





Accéder à la console H2 pour voir la base de données :





URL : http://localhost:8080/h2-console



URL JDBC : jdbc:h2:mem:donationdb



Nom d'utilisateur : sa



Mot de passe : (vide)



Utiliser Swagger UI pour explorer l'API :





URL : http://localhost:8080/swagger-ui.html

Points de terminaison API





GET /api/campagnes/actives : Récupérer les campagnes actives.



GET /api/campagnes : Récupérer toutes les campagnes.



POST /api/campagnes/{id}/dons : Créer un don pour une campagne.





Exemple de corps :

{
    "nomCampagne": "Campagne Test",
    "nomDonateur": "Jean Dupont",
    "montant": 100.00
}



GET /api/campagnes/{id}/dons : Récupérer les dons d'une campagne.





Exemple de réponse :

[
    {
        "id": 1,
        "nomCampagne": "Campagne Test",
        "nomDonateur": "Jean Dupont",
        "montant": 100.00,
        "date": "2025-04-21T09:50:00.123"
    }
]

Base de données





L'application utilise une base de données H2 en mémoire.



Les données initiales sont insérées via data.sql :





Une campagne avec id=1 est créée au démarrage.

Déploiement





Construire le JAR et déployer :

mvn clean package
java -jar target/donation-service-1.0-SNAPSHOT.jar



Docker (optionnel) :

docker build -t donation-service .
docker run -p 8080:8080 donation-service

Contribution





Forker le dépôt.



Créer une branche de fonctionnalité (git checkout -b feature/nouvelle-fonctionnalité).



Commiter les changements (git commit -m "Ajouter une nouvelle fonctionnalité").



Pousser vers la branche (git push origin feature/nouvelle-fonctionnalité).



Créer une pull request.

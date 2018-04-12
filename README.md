# Jeu de la vie en JEE

## Introduction

Nous avons réalisé ce projet de Jeu de la Vie sur le Web pendant nos études dans un but éducatif en JEE.

## Authentification

Nous avons réutilisé un système d'authentification existant. On peut se connecter avec __admin:admin__ .

## Fonctionnement

Ensuite on se retouve sur l'interface principale du site __/main__

On peut télécharger un des 5 modèles de 1 à 5 avec le bouton __download__ et le champs de texte. Une fois chargé on peut __Jouer__ la vie, ou __avancer__, __reculer__ d'une évolution.

Les fichiers des jeu se trouvent dans __tp-display-quote-v4-java/src/main/java/fr/isima/files/__ et sont rentrés à la main pour le moment.

Pour représenté la grille on a utilisé un canvas, sa taille s'adapte au dimensionnement du tableau.

Dans le but de tester un maximum de configurations. On a créé un chemin __/gameGenerator__ qui permet de générer aléatoirement des jeu de la vie selon certains paramètres écrit en dur.

## Améliorations possibles

Comme le mentionnait le sujet on aurait pu inclure une fonction de __dowload__ de fichiers textes. On a essayé sans succès.

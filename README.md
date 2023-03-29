# Gestion-Film 
### Version 1

## par ETU001592-ETU001663-ETU001618-ETU001545 

## Liste des fonctionnalités
### Simple: 
- Insertion de films/scène/role/actions
- Liste de films par realisateur
- Liste de plateaux
- Liste de scènes par films/plateaux
- Liste d'actions par scènes
- Liste d'acteurs par films
- Insertion de planning de scène
-  Pagination pour : 
  - la liste des scenes non validées / validés
  - la liste des plannings

### Complexe
- Insertion impossible de planning dans le cas où l'acteur voulu n'est pas disponible le jour du planning
- Possibilité d'insérer plusieurs scènes dans un même planning
- Générer automatiquement 2 dates lors de l'insertion d'un planning pour une scène : dates qui ne sont pas dans la liste des indisponibilités des plateaux
- Validation/Refus de plusieurs en même temps.
- Triage de scènes : soit trier en fonction de la date actuelle/ du mois actuelle/ de l'année actuelle/ de l'interval entre deux dates qu'on définit.
- Permutation de planning de deux scènes.

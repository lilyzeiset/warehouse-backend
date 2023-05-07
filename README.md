# Backend for Project 1

I ended up rebuilding my project with a more simplified db schema, but somehow my commit history got lost in the process.
Luckily I backed it up locally so I was able to re-push them to a new repo.
There probably is a way to re-add them here but I didn't want to risk messing it up more (git is confusing).
Find my old commits here: https://github.com/lilyzeiset/warehouse-backend-old/commits/main


# API Endpoints:
Endpoint | Function
---|---
GET /warehouse | finds all warehouses
GET /warehouse/{id} | finds warehouse with id {id}
GET /warehouse/{id}/items | finds all items in warehouse with id {id}
GET /warehouse/{id}/capacity | finds the current capacity of warehouse with id {id}
POST /warehouse | creates a new warehouse and returns it
PUT /warehouse/{id} | updates warehouse with id {id} and returns it
DELETE /warehouse/{id} | deletes warehouse with id {id}
GET /item | finds all items
GET /item/{id} | finds item with id {id}
POST /item | creates a new item and returns it
PUT /item/{id} | updates item with id {id} and returns it
DELETE /item/{id} | deletes item with id {id}
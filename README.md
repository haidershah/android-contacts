## Description

This app displays a static list of Contacts and gives users the ability to update Contact names.

## Motivation

List of Contacts and Contact Details are displayed on different screens. Contacts are persisted 
in a database using Room. Updating Contact Details, on its own screen, updates the Contact List
screen. This is done through LiveData. Contact List displays contacts by getting a LiveData
from the database, so any changes made to the db, get propagated to the UI. 
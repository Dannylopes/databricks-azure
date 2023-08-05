// Databricks notebook source
val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "b866f361-507b-42a6-b65d-f91ad89d5b1b",
  "fs.azure.account.oauth2.client.secret" -> "A4v8Q~u2kLmfAcZzNDJDUh5rUpOn2Ev8oNJDUcce",
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/46505875-a4f1-4a13-a17e-cb57668837ba/oauth2/token")
// Optionally, you can add <directory-name> to the source URI of your mount point.
dbutils.fs.mount(
  source = "abfss://imoveis@stackatomstorageaccount.dfs.core.windows.net/",
  mountPoint = "/mnt/dados",
  extraConfigs = configs)

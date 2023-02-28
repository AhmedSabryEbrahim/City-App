import csv
import mysql.connector

connection = mysql.connector.connect(
    host="mysql",
    user="root",
    password="password",
    database="CITY_APP",
    port="3306"
)

cursor = connection.cursor()


def query_builder(connection, cursor, id, cityName, link):
    sql = """INSERT INTO CITY_APP.cities ( city_name, link) VALUES ( %s, %s)"""
    val = (cityName, "\"" + link + "\"")
    cursor.execute(sql, val)
    connection.commit()


with open('cities.csv') as csv_file:
    csv_reader = csv.reader(csv_file)
    header = 0
    for row in csv_reader:
        if (header != 0):
            query_builder(connection, cursor, row[0], row[1], row[2])
        header = 1

    cursor.close()
    connection.close()

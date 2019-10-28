import csv
import codecs
import datetime


txt_file = r"artists.csv"
csv_file = r"artistFinal.csv"

ARTISTID = 0
NAME = 1
NATIONALITY = 2
GENDER = 3
BIRTH_YEAR = 4
DEATH_YEAR = 5


with open(txt_file, "r") as in_text:
    in_reader = csv.reader(codecs.open(txt_file), delimiter = ',')
    with open(csv_file, "w") as out_csv:
        out_writer = csv.writer(out_csv)
        i = 1
        print (in_reader)
        for row in in_reader:
            i=i+1
            print(row)

            a = row[NATIONALITY]
            if a == '' or a == None :
                continue

            a = row[GENDER]
            if a == '' or a == None:
                continue

            a = row[BIRTH_YEAR]
            if a == '' or a == None:
                continue

            a = row[DEATH_YEAR]
            if a == '' or a == None:
                continue

            out_writer.writerow(row)
print('total records', i)


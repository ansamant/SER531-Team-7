import csv
import codecs
import datetime


txt_file = r"artworks.csv"
csv_file = r"artworksCleaned.csv"

Artwork_ID = 0
Title = 1
Artist_ID = 2
Name = 3
Date = 4
Medium = 5
Dimensions = 6
Acquisition_Date = 7
Credit = 8
Catalogue = 9
Department = 10
Classification = 11
Object_Number = 12
Height = 13
Width = 14


with open(txt_file, "r") as in_text:
    in_reader = csv.reader(codecs.open(txt_file), delimiter = ',')
    with open(csv_file, "w") as out_csv:
        out_writer = csv.writer(out_csv)
        i = 0
        print (in_reader)
        for row in in_reader :
            i = i+1
            print(row)

            a = row[Artwork_ID]
            if a == '' or a is None :
                continue

            a = row[Title]
            if a == '' or a is None:
                continue

            a = row[Artist_ID]
            if a == '' or a is None:
                continue

            a = row[Name]
            if a == '' or a is None:
                continue

            a = row[Date]
            if a == '' or a is None:
                continue

            a = row[Medium]
            if a == '' or a is None:
                continue

            a = row[Dimensions]
            if a == '' or a is None:
                continue

            a = row[Acquisition_Date]
            if a == '' or a is None:
                continue

            a = row[Credit]
            if a == '' or a is None:
                continue

            a = row[Catalogue]
            if a == '' or a is None:
                continue

            a = row[Department]
            if a == '' or a is None:
                continue

            a = row[Classification]
            if a == '' or a is None:
                continue

            a = row[Object_Number]
            if a == '' or a is None:
                continue

            a = row[Height]
            if a == '' or a is None:
                continue

            a = row[Width]
            if a == '' or a is None:
                continue

            out_writer.writerow(row)
print('total records', i)


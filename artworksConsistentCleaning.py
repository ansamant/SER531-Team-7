import csv
import codecs
import datetime


artist_file = r"artistFinal.csv"
artwork_inputfile = r"artworksCleaned.csv"
artwork_outfile = r"artworksFinal.csv"

with open(artist_file, "r") as artist_input, open(artwork_inputfile, "r") as artwork_input :
    artist_reader = csv.reader(codecs.open(artist_file), delimiter = ',')
    artwork_reader = csv.reader(codecs.open(artwork_inputfile), delimiter=',')
    with open(artwork_outfile, "w") as out_csv:
        out_writer = csv.writer(out_csv)
        artistID_list = []
        i = 0
        for row in artist_reader:
            artistID_list.append(row[0])

        for row in artwork_reader:
            a = row[2]
            if a not in artistID_list:
                continue
            out_writer.writerow(row)
            i = i+1
print('total records', i)


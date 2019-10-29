import csv
import codecs
import datetime

artwork_inputfile = r"artworksFinal.csv"
location_file = r"location.csv"
artwork_outfile = r"artworks10k.csv"

with open(artwork_inputfile, "r") as artwork_input, open(location_file, "r") as location_input :

    artwork_reader = csv.reader(codecs.open(artwork_inputfile), delimiter=',')
    location_reader = csv.reader(codecs.open(location_file), delimiter = ',')
    with open(artwork_outfile, "w") as out_csv:
        out_writer = csv.writer(out_csv)
        i = 0
        artworkID_list = []
        for row in location_reader:
            artworkID_list.append(row[3])

        for row in artwork_reader:
            a = row[0]
            if a not in artworkID_list:
                continue
            out_writer.writerow(row)
            i = i+1
print('total records', i)


import pandas as pd

'''
Code takes the Artwork ID in artworksFinal.csv 
and adds it to the coordinate dataset found in demo.xlsx
Then writes a new .csv file with all three data values.
Replace <filePath> with  your file path
'''
df_1 = pd.read_csv('<filePath>/artworksFinal.csv')
df_list = df_1['Artwork ID'].tolist()
df_list = df_list[:10000]
serie = pd.Series(df_list)
print(serie.size)
df_2 = pd.read_excel('<filePath>/demo.xlsx')
df_2 = df_2.drop_duplicates(subset=['latitude', 'longitude'])
print(df_2.size)
df_2['Artwork ID'] = serie.values
df_2.to_csv('<filePath>/<fileName.csv>')
print(df_2.head())
print(df_2.size)



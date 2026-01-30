import pandas as pd
import ftfy  # Fixes mojibake automatically

def clean_and_fix_csv(input_file, output_file):
    # Reads CSV with UTF-8 (fallback to latin1 if UTF-8 fails)
    try:
        df = pd.read_csv(input_file, encoding='utf-8')
    except UnicodeDecodeError:
        df = pd.read_csv(input_file, encoding='latin1')

    #  Clean and fix all string columns
    for col in df.select_dtypes(include='string').columns:  # Pandas 2.x
        df[col] = df[col].apply(lambda x: ftfy.fix_text(x) if isinstance(x, str) else x)
        # Remove hidden control chars
        df[col] = df[col].str.replace(r'[\x00-\x08\x0b\x0c\x0e-\x1f\x7f]', '', regex=True)
        df[col] = df[col].str.replace('\xa0', ' ')  # NBSP normal space
        df[col] = df[col].str.strip()  # remove leading/trailing spaces

    # Save clean CSV in UTF-8
    df.to_csv(output_file, index=False, encoding='utf-8')

clean_and_fix_csv("trash.csv", "Data_LaLiga_2024_2025.csv")
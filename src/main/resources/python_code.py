# import pandas as pd
# import json
# from datetime import datetime
# import random
# import string
# import re
# import os

# All lines are commented out and file paths are hidden 

# # Method to comment out all lines except a specific method
def comment_out_except_method(script, method_name):
    import os

#     # Extract the directory and filename
#     script_dir, script_name = os.path.split(script)
#     commented_file = os.path.join(script_dir, "commented_" + script_name)
# 
#     try:
#         # Read the original file
#         with open(script, "r") as file:
#             lines = file.readlines()
# 
#         # Write to the commented file
#         with open(commented_file, "w") as file:
#             inside_method = False
# 
#             for line in lines:
#                 stripped_line = line.strip()
#                 # Detect the start of the method
#                 if stripped_line.startswith(f"def {method_name}("):
#                     inside_method = True
#                     file.write(line)
#                 # Detect the end of the method
#                 elif inside_method and stripped_line == "":
#                     inside_method = False
#                     file.write(line)
#                 # Write lines inside the method normally
#                 elif inside_method:
#                     file.write(line)
#                 # Comment out everything else
#                 else:
#                     file.write(f"# {line}")
# 
#         print(f"Commented file created: {commented_file}")
# 
#     except Exception as e:
#         print(f"Error processing file: {e}")
# 
# 
# # Method to obfuscate file paths
# def hide_file_paths(script):
# 
#     # Extract the directory and filename
#     script_dir, script_name = os.path.split(script)
#     hidden_file = os.path.join(script_dir, "hidden_paths_" + script_name)
# 
#     try:
#         # Read the original file
#         with open(script, "r") as file:
#             lines = file.readlines()
# 
#         # Write to the hidden file
#         with open(hidden_file, "w") as file:
#             for line in lines:
#                 # Use regex to find file paths and replace them
#                 hidden_line = re.sub(r"[A-Za-z]:[\\\\/](?:[^\\\\/\"']+[\\\\/]*)*", "HIDDEN_PATH/", line)
#                 file.write(hidden_line)
# 
#         print(f"File with hidden paths created: {hidden_file}")
# 
#     except Exception as e:
#         print(f"Error processing file: {e}")
# 
# 
# # Main Execution
# # Specify the script file path
# script_file_path = "HIDDEN_PATH/"
# 
# # Specify the methods you want to keep uncommented
# methods_to_keep = ["hide_file_paths", "comment_out_except_method"]
# 
# # Step 1: Comment out all lines except specified methods
# for method in methods_to_keep:
#     comment_out_except_method(script_file_path, method)
# 
# # Step 2: Hide file paths in the commented script
# commented_script_path = "HIDDEN_PATH/"  # Adjust as needed
# hide_file_paths(commented_script_path)
# 
# 
# # Load your original CSV file for grape variety table
# file_path = r"HIDDEN_PATH/"
# data = pd.read_csv(file_path)
# 
# # Function to clean and beautify string values
# def clean_and_beautify(value):
#     if isinstance(value, str):
#         # Remove outer quotes, escape inner quotes
#         value = value.replace('"', '').replace("'", "\\'")
#         return value.strip()
#     return value
# 
# # Apply cleaning function to all string columns
# data = data.applymap(clean_and_beautify)
# 
# # Convert the DataFrame to JSON with proper formatting
# json_output = json.dumps(json.loads(data.to_json(orient="records")), indent=4)
# 
# # Save the formatted JSON to a file
# output_path = r"HIDDEN_PATH/"
# with open(output_path, "w") as f:
#     f.write(json_output)
# 
# print(f"Formatted JSON file saved to {output_path}")
# 
# 
# 
# # Load the CSV file for harvest table
# file_path = r"HIDDEN_PATH/"
# data = pd.read_csv(file_path)
# 
# # Drop unnecessary columns
# data = data.drop(columns=["Variety"])
# 
# # Rename columns to match database schema
# data = data.rename(columns={
#     "Year": "year",
#     "Variety_ID": "variety_id",
#     "Harvest_date": "harvest_date",
#     "Pressed_date": "crush_date",
#     "Harvest_ID": "harvest_id",
#     "Pounds": "pounds"
# })
# 
# # Normalize 'location'
# def normalize_location(row):
#     if row["Home"] == 1.0:
#         return "Home"
#     elif pd.notna(row["Other_Location"]):
#         return row["Other_Location"].strip()
#     else:
#         return "Unknown"
# 
# data["location"] = data.apply(normalize_location, axis=1)
# 
# # Drop original location columns
# data = data.drop(columns=["Home", "Other_Location"])
# 
# # Inspect and clean data
# data["harvest_date"] = pd.to_datetime(data["harvest_date"], errors="coerce")
# data["crush_date"] = pd.to_datetime(data["crush_date"], errors="coerce")
# data["year"] = data["year"].astype(int, errors="ignore")
# data["pounds"] = data["pounds"].astype(float, errors="ignore")
# 
# # Convert to JSON for ingestion
# json_output = data.to_json(orient="records", indent=4)
# 
# # Save the JSON file
# output_path = r"HIDDEN_PATH/"
# with open(output_path, "w") as f:
#     f.write(json_output)
# #
# print(f"Cleaned harvest JSON saved to {output_path}")
# #
# # Post-processing of json file for date conversion
# # Path to the JSON file
# input_file = r"HIDDEN_PATH/"
# output_file = r"HIDDEN_PATH/"
# 
# def convert_timestamp_to_date(timestamp):
#     """Convert milliseconds since epoch to yyyy-MM-dd format."""
#     if timestamp is not None:
#         return datetime.fromtimestamp(timestamp / 1000).strftime('%Y-%m-%d')
#     return None
# 
# # Load the JSON file
# with open(input_file, 'r') as f:
#     data = json.load(f)
# 
# # Update the date fields
# for record in data:
#     record["harvest_date"] = convert_timestamp_to_date(record.get("harvest_date"))
#     record["crush_date"] = convert_timestamp_to_date(record.get("crush_date"))
# 
# # Save the updated JSON file
# with open(output_file, 'w') as f:
#     json.dump(data, f, indent=4)
# 
# print(f"Updated JSON saved to {output_file}")
# #
# # Input and output file paths
# input_file = r"HIDDEN_PATH/"
# output_file = r"HIDDEN_PATH/"
# 
# def nest_variety_id(data):
#     """Nest 'variety_id' into a 'variety' object for each record."""
#     for record in data:
#         if "variety_id" in record:
#             record["variety"] = {"variety_id": record.pop("variety_id")}
#     return data
# 
# # Load the JSON data
# with open(input_file, "r") as f:
#     data = json.load(f)
# 
# # Modify the data
# updated_data = nest_variety_id(data)
# 
# # Save the updated JSON
# with open(output_file, "w") as f:
#     json.dump(updated_data, f, indent=4)
# 
# print(f"Updated JSON saved to {output_file}")
# #
# # Validating harvest id
# #
# # Load the dataset
# file_path = r"HIDDEN_PATH/"
# with open(file_path, "r") as file:
#     data = pd.read_json(file)
# 
# # Ensure 'harvest_id' column exists
# if "harvest_id" in data.columns:
#     # Step 1: Convert to string
#     data["harvest_id"] = data["harvest_id"].astype(str)
# 
#     # Step 2: Validate format (e.g., length of 6 and alphanumeric)
#     def validate_harvest_id(harvest_id):
#         # Check if ID is 6 characters long and alphanumeric
#         if len(harvest_id) == 6 and harvest_id.isalnum():
#             return harvest_id
#         else:
#             return None  # Mark invalid values as None
# 
#     data["harvest_id"] = data["harvest_id"].apply(validate_harvest_id)
# 
#     # Step 3: Handle invalid IDs
#     if data["harvest_id"].isnull().any():
#         print("Warning: Some harvest IDs are invalid. Please review the dataset.")
#         # Optional: Drop rows with invalid IDs
#         # data = data.dropna(subset=["harvest_id"])
# 
# else:
#     print("Error: 'harvest_id' column not found in the dataset.")
# 
# # Save the cleaned data back to a CSV or JSON
# output_path = r"HIDDEN_PATH/"
# data.to_json(output_path, orient="records", indent=4)
# print(f"Cleaned data saved to {output_path}")
# 
# # Load the old CSV file
# file_path = r"HIDDEN_PATH/"
# data = pd.read_csv(file_path)
# 
# # Rename columns to match the final project schema
# data = data.rename(columns={
#     "Vinification_ID": "vinification_id",
#     "Harvest_ID": "harvest_id",
#     "Gallons": "gallons",
#     "pH": "pH_level",
#     "Must_temperature": "must_temperature",
#     "Original_gravity": "original_gravity",
#     "Brix": "brix",
#     "Maceration": "maceration",
#     "Chaptalization": "chaptalization",
#     "Pounds_sugar_added": "pounds_sugar_added",
#     "Yeast_strand": "yeast_strand",
#     "Malolactic_Fermintation": "malolactic_fermentation",
#     "Inoculated": "inoculation_date"
# })
# 
# # Drop columns not used in the final project
# data = data.drop(columns=["Year", "Variety", "Home", "Variety_ID"])
# 
# # Combine "Red_Wine", "White_Wine", and "Rosé" into "wine_style"
# def determine_wine_style(row):
#     styles = []
#     if row.get("Red_Wine", 0) == 1:
#         styles.append("Red")
#     if row.get("White_Wine", 0) == 1:
#         styles.append("White")
#     if row.get("Rosé", 0) == 1:
#         styles.append("Rosé")
#     return ", ".join(styles) if styles else None
# 
# data["wine_style"] = data.apply(determine_wine_style, axis=1)
# 
# # Drop the original wine style columns
# data = data.drop(columns=["Red_Wine", "White_Wine", "Rosé"])
# 
# # Convert boolean-like columns (e.g., 1.0 = "Yes", 0.0 = "No")
# boolean_columns = ["malolactic_fermentation", "chaptalization", "maceration"]
# 
# # Map numeric values to boolean
# for col in boolean_columns:
#     data[col] = data[col].apply(lambda x: True if x == 1.0 else False)
# 
# 
# # Nest `harvest_id` into a `harvest` object
# data["harvest"] = data["harvest_id"].apply(lambda x: {"harvest_id": x})
# data = data.drop(columns=["harvest_id"])  # Drop the original `harvest_id` column after nesting
# 
# # Save to JSON
# output_path = r"HIDDEN_PATH/"
# data.to_json(output_path, orient="records", indent=4)
# 
# print(f"Processed data saved to {output_path}")
# 
# # Makeup files for harvest and vinification tables
# 
# # Function to generate random alphanumeric IDs
# def generate_random_id(length=6):
#     return ''.join(random.choices(string.ascii_uppercase + string.digits, k=length))
# 
# # File paths
# harvest_file = r"HIDDEN_PATH/"
# vinification_file = r"HIDDEN_PATH/"
# harvest_json_output = r"HIDDEN_PATH/"
# vinification_json_output = r"HIDDEN_PATH/"
# 
# # Load the harvest_updated CSV
# harvest_data = pd.read_csv(harvest_file)
# 
# # Ensure columns are clean and consistent
# harvest_data.columns = harvest_data.columns.str.strip()
# 
# # Generate random harvest_id for missing values
# harvest_data['harvest_id'] = harvest_data['harvest_id'].fillna(
#     harvest_data.apply(lambda _: generate_random_id(), axis=1)
# )
# 
# # Format dates in harvest_data
# def format_date(date_str):
#     try:
#         return datetime.strptime(date_str, "%m/%d/%Y").strftime("%Y-%m-%d")
#     except Exception:
#         return None
# 
# harvest_data["harvest_date"] = harvest_data["harvest_date"].apply(format_date)
# harvest_data["crush_date"] = harvest_data["crush_date"].apply(format_date)
# 
# # Nest variety_id within harvest for JSON
# harvest_data["variety"] = harvest_data["variety_id"].apply(lambda x: {"variety_id": x})
# harvest_data = harvest_data.drop(columns=["variety_id"])  # Drop plain variety_id column
# 
# # Save harvest data to JSON
# harvest_data_json = harvest_data.to_json(orient="records", indent=4)
# with open(harvest_json_output, "w") as f:
#     f.write(harvest_data_json)
# print(f"Harvest data saved to {harvest_json_output}")
# 
# # Load the vinification_updated CSV
# vinification_data = pd.read_csv(vinification_file)
# 
# # Ensure columns are clean and consistent
# vinification_data.columns = vinification_data.columns.str.strip()
# 
# # Generate random vinification_id for missing values
# vinification_data['vinification_id'] = vinification_data['vinification_id'].fillna(
#     vinification_data.apply(lambda _: generate_random_id(), axis=1)
# )
# 
# # Map variety_id to harvest_id using harvest_data
# variety_to_harvest = {
#     row['variety']['variety_id']: row['harvest_id']
#     for _, row in harvest_data.iterrows()
# }
# vinification_data['harvest_id'] = vinification_data['variety_id'].map(variety_to_harvest)
# 
# # Check for unmapped variety_ids
# if vinification_data['harvest_id'].isnull().any():
#     missing_varieties = vinification_data[vinification_data['harvest_id'].isnull()]['variety_id'].unique()
#     print(f"Error: Unmapped variety_ids found: {missing_varieties}")
# 
# # Format dates in vinification_data
# vinification_data["inoculation_date"] = vinification_data["inoculation_date"].apply(format_date)
# 
# # Nest harvest_id within vinification for JSON
# vinification_data["harvest"] = vinification_data["harvest_id"].apply(lambda x: {"harvest_id": x})
# vinification_data = vinification_data.drop(columns=["harvest_id", "variety_id"])  # Drop plain keys
# 
# 
# # Save vinification data to JSON
# vinification_data_json = vinification_data.to_json(orient="records", indent=4)
# with open(vinification_json_output, "w") as f:
#     f.write(vinification_data_json)
# print(f"Vinification data saved to {vinification_json_output}")
# #
# # Correcting boolean values in vinification_makeup.json
# #
# # File path for the JSON file
# vinification_json_path = r"HIDDEN_PATH/"
# 
# # Load the JSON file
# with open(vinification_json_path, 'r') as file:
#     vinification_data = json.load(file)
# 
# # Fix boolean values
# for entry in vinification_data:
#     # Convert "Yes"/"No" to True/False for boolean fields
#     if "maceration" in entry:
#         entry["maceration"] = True if entry["maceration"] == "Yes" else False
#     if "chaptalization" in entry:
#         entry["chaptalization"] = True if entry["chaptalization"] == "Yes" else False
#     if "malolactic_fermentation" in entry:
#         entry["malolactic_fermentation"] = True if entry["malolactic_fermentation"] == "Yes" else False
# 
# # Save the fixed JSON data back to the file
# with open(vinification_json_path, 'w') as file:
#     json.dump(vinification_data, file, indent=4)
# 
# print(f"Boolean values fixed in {vinification_json_path}")
# 
# # Converting wine_cellar.csv to json file for ingestion
# 
# # File paths
# input_csv = r"HIDDEN_PATH/"
# output_json = r"HIDDEN_PATH/"
# 
# # Load the CSV file
# data = pd.read_csv(input_csv)
# 
# # Ensure `alcohol_percentage` is explicitly set to None (or null in JSON)
# data["alcohol_percentage"] = None
# 
# # Nest the foreign key `vinification_id` into a dictionary if needed
# if "vinification_id" in data.columns:
#     data["vinification"] = data["vinification_id"].apply(
#         lambda x: {"vinification_id": x} if pd.notnull(x) else None
#     )
#     data = data.drop(columns=["vinification_id"])  # Drop the flat foreign key column
# 
# def set_vinification(bottle_id, vinification_id):
#     if "VB" in bottle_id:
#         return None  # Blended wines have no direct vinification_id
#     return {"vinification_id": vinification_id} if pd.notnull(vinification_id) else None
# #
# # Apply this logic to create the vinification field
# data["vinification"] = data.apply(
#     lambda row: set_vinification(row["bottle_id"], row["vinification_id"]),
#     axis=1
# )
# data = data.drop(columns=["vinification_id"])  # Drop the flat foreign key column
# 
# 
# # Convert to JSON
# data_json = data.to_json(orient="records", indent=4)
# 
# # Save the JSON file
# with open(output_json, "w") as f:
#     f.write(data_json)
# 
# print(f"Processed data saved to {output_json}")
# 
# # Adding unique identifier to vinification blend data and converting csv to json
# 
# # Function to generate random alphanumeric IDs
# def generate_random_id(length=6):
#     return ''.join(random.choices(string.ascii_uppercase + string.digits, k=length))
# 
# # File paths
# input_csv = r"HIDDEN_PATH/"
# output_json = r"HIDDEN_PATH/"
# 
# # Load the spreadsheet
# data = pd.read_csv(input_csv)
# 
# # Generate unique vinification_blend_id for each row
# data['vinification_blend_id'] = data.apply(lambda _: generate_random_id(), axis=1)
# 
# # Nest bottle_id and vinification_id as foreign key objects
# data['bottle'] = data['bottle_id'].apply(lambda x: {"bottle_id": x})
# data['vinification'] = data['vinification_id'].apply(lambda x: {"vinification_id": x})
# 
# # Drop the plain foreign key columns
# data = data.drop(columns=['bottle_id', 'vinification_id'])
# 
# # Save the JSON file
# data_json = data.to_json(orient="records", indent=4)
# with open(output_json, "w") as f:
#     f.write(data_json)
# 
# print(f"JSON file saved to {output_json}")
# 
# # File paths
# csv_file_path = r"HIDDEN_PATH/"
# json_file_path = r"HIDDEN_PATH/"
# 
# # Function to format dates
# def format_date(date_str):
#     try:
#         return datetime.strptime(date_str, "%m/%d/%Y").strftime("%Y-%m-%d")
#     except Exception:
#         return None  # Handle invalid or missing dates
# 
# # Load the CSV file
# data = pd.read_csv(csv_file_path)
# 
# # Format the date column if present
# if 'start_date' in data.columns:
#     data['start_date'] = data['start_date'].apply(format_date)
# 
# # Nest the foreign key (vinification_id) as a dictionary
# if 'vinification_id' in data.columns:
#     data['vinification'] = data['vinification_id'].apply(lambda x: {"vinification_id": x})
#     data = data.drop(columns=['vinification_id'])  # Drop the plain foreign key column
# 
# # Save to JSON
# data.to_json(json_file_path, orient="records", indent=4)
# 
# print(f"JSON file has been saved to: {json_file_path}")

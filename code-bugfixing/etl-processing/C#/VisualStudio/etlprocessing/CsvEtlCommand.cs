public class CsvEtlCommand
{
    private string sourceFile;
    private string targetFile;

    public CsvEtlCommand(string sourceFile, string targetFile)
    {
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
    }

    public void Execute()
    {
        using (var reader = new StreamReader(sourceFile))
        using (var writer = new StreamWriter(targetFile))
        {
            // Extract
            string line = reader.ReadLine();

            // Transform and Load
            while (line != null)
            {
                string[] columns = line.Split(',');
                var transformedLine = Transform(columns);

                writer.WriteLine(transformedLine);
                line = reader.ReadLine();
            }
        }
    }

    private string Transform(string[] columns)
    {
        // Add a simple transformation: reverse the order of the columns
        string transformed = "";
        for (int i = columns.Length - 1; i >= 0; i--)
        {
            transformed += columns[i];
            if (i > 0) transformed += ",";
        }
        return transformed;
    }
}


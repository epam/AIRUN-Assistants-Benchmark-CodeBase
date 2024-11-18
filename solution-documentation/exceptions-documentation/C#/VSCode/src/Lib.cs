using src.Model;

namespace src
{
    public class Lib
    {
        /// <exception cref="ArgumentException">
        /// 
        /// </exception>
        /// <exception cref="NullReferenceException">
        /// 
        /// </exception>
        /// <exception cref="InvalidOperationException">
        /// 
        /// </exception>
        /// <exception cref="System.IO.FileNotFoundException">
        /// 
        /// </exception>
        public string PublishArticle(string title, string content, Author author)
        {
            if (string.IsNullOrWhiteSpace(title) || string.IsNullOrWhiteSpace(content))
            {
                throw new ArgumentException("Title & content is required");
            }

            if (author == null)
            {
                throw new NullReferenceException("Author is null");
            }

            if (!author.CanPublish)
            {
                throw new InvalidOperationException($"{author.Name} cannot publish articles");
            }

            try
            {
                var txt = File.ReadAllText(author.ArticlesLocation);
            }
            catch
            {
                throw new System.IO.FileNotFoundException("There is no file to publish or it is corrupted");
            }

            return $"Article {title} by {author} was published.";
        }   
    }
}
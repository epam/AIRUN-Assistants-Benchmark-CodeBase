namespace src.Interface
{
    public class Book
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Author { get; set; }
        public string Name { get; set; }
    }

    public interface IBookService
    {
        Task<IEnumerable<Book>> GetAll();
        Task<Book> Get(int id);
        Task<Book> Create(Book book);
        Task<Book> Update(Book book);
        Task Delete(int id);
    }
}

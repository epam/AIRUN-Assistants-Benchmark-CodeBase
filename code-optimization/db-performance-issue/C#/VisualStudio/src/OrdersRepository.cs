using Context;
using Context.Models;

namespace src
{
    public class OrdersRepository
    {
        private readonly OrderContext _context;

        public OrdersRepository(OrderContext context)
        {
            _context = context ?? throw new ArgumentNullException("Context is null");
        }

        public IEnumerable<Order> GetAllNonCompletedOrdersNonOptimized()
        {
            return _context.Orders
                .ToList()
                .Where(o => o.IsComplete == false);
        }
        
    }
}